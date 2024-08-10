[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/1h1ehu8e)
# Scalable WebPOS

The repository in the `src` directory provides access to certain products on JD.com. Please use it as a data source for the Restful WebOS implemented by aw04, and fulfill the following requirements:

1. Build a Docker image for this application and run it in docker container with differnet cpus. Perform a load testing against it.
2. Make this system horizontally scalable by using haproxy and perform load testing against it.
3. Take care of the **cache missing** problem (you **MUST CACHE** the products from jd.com otherwise you'll get yourself blocked). You may use a redis cluster. Perform load testings.

Please **write a report** on the performance differences you noticed among the above tasks.

