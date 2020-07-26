#Author : Parth Panchal
#Modified the docker file obtained from Google Cloud Run
# source : https://cloud.google.com/run/docs/quickstarts/build-and-deploy#python_1
# Use the official lightweight Python image.
# https://hub.docker.com/_/python
FROM python:3.7-slim

# Copy local code to the container image.
ENV APP_HOME /app
WORKDIR $APP_HOME
COPY ../../../../../../../../../../PycharmProjects/CrewScheduling ./

# Install production dependencies.
RUN pip install Flask gunicorn
RUN pip3 install -r requirements.txt
RUN pip install tbb
# Run the web service on container startup. Here we use the gunicorn
# webserver, with one worker process and 8 threads.
# For environments with multiple CPU cores, increase the number of workers
# to be equal to the cores available.
CMD exec gunicorn --bind :$PORT --workers 1 --threads 8 --timeout 0 app:app