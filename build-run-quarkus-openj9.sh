#!/bin/bash
set -euo pipefail
cd ${0%/*}

docker build -t quarkus-openj9 -f Dockerfile.openj9 .

docker run --rm -d \
  -p 8001:8080 \
  --network dkrnet \
  --name quarkus-openj9 \
  quarkus-openj9
