package com.squid314.screeps

import scala.scalajs.js.annotation.JSExportTopLevel
import com.screeps.native.Game
import com.squid314.screeps.roles.Harvester

object Screeps {
  @JSExportTopLevel("loop")
  def loop(): Unit = {
    val maybeFirstCreep = Game.creeps.headOption
    if(maybeFirstCreep.isDefined){
        new Harvester(maybeFirstCreep.get._2).run
    }
  }
}
