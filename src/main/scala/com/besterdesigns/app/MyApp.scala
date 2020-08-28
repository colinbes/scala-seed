package com.besterdesigns.app

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object MyApp extends App {
  val logger: Logger = LoggerFactory.getLogger("MyApp")
  logger.info("Hello World")
}
