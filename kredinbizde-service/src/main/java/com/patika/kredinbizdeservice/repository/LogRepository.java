package com.patika.kredinbizdeservice.repository;

import org.apache.commons.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {

    void saveLogWithException(String message, Exception exception);
}
