#!/bin/bash

# PostgreSQL database password
db_password="Database"

# Check if PostgreSQL user 'postgres' exists
user_exists=$(PGPASSWORD=$db_password psql -U postgres -tAc "SELECT 1 FROM pg_roles WHERE rolname='postgres'")
if [[ -z $user_exists ]]; then
    # Create PostgreSQL user 'postgres' if it doesn't exist
    echo "Creating PostgreSQL user 'postgres'"
    PGPASSWORD=$db_password createuser -U postgres -s postgres
else
    echo "PostgreSQL user 'postgres' already exists"
fi

# Check if PostgreSQL database 'railwaybooking' exists
db_exists=$(PGPASSWORD=$db_password psql -U postgres -tAc "SELECT 1 FROM pg_database WHERE datname='railwaybooking'")
if [[ -z $db_exists ]]; then
    # Create PostgreSQL database 'railwaybooking' if it doesn't exist
    echo "Creating PostgreSQL database 'railwaybooking'"
    PGPASSWORD=$db_password createdb -U postgres railwaybooking
else
    echo "PostgreSQL database 'railwaybooking' already exists"
fi

# Check script arguments
if [[ $1 == "-run" ]]; then
    # Run Spring Boot application with jar file 'app-0.0.1-SNAPSHOT.jar'
    echo "Running Spring Boot application"
    java -jar build/libs/app-0.0.1-SNAPSHOT.jar
elif [[ $1 == "-build" ]]; then
    # Build Gradle project using gradlew
    echo "Building Gradle project 'Railway Booking'"
    echo "---------------------------------------------------------"
    ./gradlew build -x test
else
    # Build Gradle project using gradlew
    echo "Building Gradle project 'Railway Booking'"
    echo "---------------------------------------------------------"
    ./gradlew build -x test

    # Run Spring Boot application with jar file 'app-0.0.1-SNAPSHOT.jar'
    echo "Running Spring Boot application"
    java -jar build/libs/app-0.0.1-SNAPSHOT.jar
fi
