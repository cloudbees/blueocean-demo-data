# scratch would be better but it misses chown
FROM busybox

# Should be equal to UID/GID used in the Jenkins image
# see https://github.com/jenkinsci/docker/blob/7c03a374604a8f7224f459873a4ce8fdf4310db5/Dockerfile#L10
ARG gid=1000
ARG uid=1000

ADD data /var/jenkins_home
RUN chown -R ${uid}:${gid} /var/jenkins_home
VOLUME /var/jenkins_home

# really, we don't want to run anything from this image
ENTRYPOINT ["/bin/false"]
