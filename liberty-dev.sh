#!/bin/bash
set -euo pipefail
cd ${0%/*}

mvn clean package liberty:dev -DverifyTimeout=120
