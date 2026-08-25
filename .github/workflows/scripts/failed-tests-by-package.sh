#!/usr/bin/env bash
# Groups failing/erroring test classes (from surefire .txt reports) by their
# immediate sub-package under com.github.vihaan.codewars (kyu3, kyu4, ...)
# and writes the result to failed-tests-report.md, also appending it to the
# GitHub Actions job summary when available.
set -euo pipefail

REPORT_DIR="target/surefire-reports"
OUT="failed-tests-report.md"

echo "## Failed test classes by package" > "$OUT"

declare -A FAILGROUPS

if [ -d "$REPORT_DIR" ]; then
  for txt in "$REPORT_DIR"/*.txt; do
    [ -f "$txt" ] || continue
    summary=$(grep -m1 '^Tests run:' "$txt" || true)
    [ -z "$summary" ] && continue

    failures=$(echo "$summary" | sed -n 's/.*Failures: \([0-9]*\).*/\1/p')
    errors=$(echo "$summary" | sed -n 's/.*Errors: \([0-9]*\).*/\1/p')

    if [ "${failures:-0}" -gt 0 ] || [ "${errors:-0}" -gt 0 ]; then
      fqcn=$(basename "$txt" .txt)
      pkg=$(echo "$fqcn" | sed -n 's/^com\.github\.vihaan\.codewars\.\([^.]*\)\..*/\1/p')
      [ -z "$pkg" ] && pkg="(other)"
      FAILGROUPS["$pkg"]+="${fqcn}"$'\n'
    fi
  done
fi

if [ ${#FAILGROUPS[@]} -eq 0 ]; then
  echo "No failing test classes. ✅" >> "$OUT"
else
  for pkg in $(printf '%s\n' "${!FAILGROUPS[@]}" | sort); do
    echo "### ${pkg}" >> "$OUT"
    printf '%s\n' "${FAILGROUPS[$pkg]}" | sed '/^$/d' | sort | sed 's/^/- /' >> "$OUT"
    echo "" >> "$OUT"
  done
fi

cat "$OUT"

if [ -n "${GITHUB_STEP_SUMMARY:-}" ]; then
  cat "$OUT" >> "$GITHUB_STEP_SUMMARY"
fi
