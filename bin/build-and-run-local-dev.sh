#!/usr/bin/env bash
set -eu -o pipefail

PROJECT_ROOT="$(cd -P "$( dirname "${BASH_SOURCE[0]}" )/.." && pwd)"

# no-op if nothing changed
docker build -t blueocean/blueocean-demo-data:local "$PROJECT_ROOT"

# cleanup previous demo data volume
docker rm -v blueocean-demo-data || true
docker create --name blueocean-demo-data blueocean/blueocean-demo-data:local
docker run --rm -p 8080:8080 --volumes-from blueocean-demo-data blueocean-dev:local
