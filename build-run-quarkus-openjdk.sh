#!/bin/bash
set -euo pipefail
cd ${0%/*}

docker build -t quarkus-openjdk -f Dockerfile.openjdk .

docker run --rm -d \
  -p 8002:8080 \
  --network dkrnet \
  --name quarkus-openjdk \
  quarkus-openjdk
