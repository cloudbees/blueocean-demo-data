# BlueOcean demo data

This repository contains some example data to showcase BlueOcean UI. It's
designed as a Docker volume container which can be attached to a BlueOcean
docker image to have example data.

# Usage

`bin` contains few handful scripts to use the demo locally.

* `build-and-run-latest.sh` launch BlueOcean latest dev image with the demo data found in this repo
* `build-and-run-local-dev.sh` launch BlueOcean local dev image with the demo data found in this repo. To build the BlueOcean local dev image, run `bin/build-in-docker.sh -m` in BlueOcean source.
* `run.sh` launch latest BlueOcean image available on Docker Hub with latest demo data container 

These scripts start a BlueOcean container which is accessible locally on port 8080.

# Security

The instance is configured so that:

* it can be accessed anonymously, only read permission is granted to anonymous
* an administrator called "admin" is created. Its password is randomly chosen and logged in the startup log

Administrator name and password can be changed on startup by passing `ADMIN_USERNAME` and `ADMIN_PASSWORD` environment variables to the BlueOcean container.
