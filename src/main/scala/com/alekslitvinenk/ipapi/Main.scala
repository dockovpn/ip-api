package com.alekslitvinenk.ipapi

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.{complete, extractClientIP, get, pathSingleSlash}
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContext
import scala.util.Try

object Main extends App {
  
  implicit val system: ActorSystem = ActorSystem("my-system")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContext = system.dispatcher
  
  private val interface = Try(args(0)).getOrElse("127.0.0.1")
  
  private val route = pathSingleSlash {
    get {
      extractClientIP { ip =>
        complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, ip.toOption.map(_.getHostAddress).getOrElse("unknown")))
      }
    }
  }
  
  Http().bindAndHandle(route, interface, 8080)
  
}
