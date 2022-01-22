package com.squid314.screeps.roles

import com.screeps.native.Creep
import com.screeps.native.RoomObject
import com.screeps.native.Source
import com.screeps.native.Constants._
import com.screeps.native.FindOptions
import scala.scalajs.js.UndefOrOps

class Harvester(creep: Creep) extends Role {

  override def run: Unit = {
    import Error._
    val maybeTarget: Option[Source] = findClosestSource(creep)
    if(maybeTarget.isDefined){
      val target = maybeTarget.get
      creep.harvest(target) match {
        case OK.i => creep.say("Harvesting!")
        case NotOwner.i => ???
        case Busy.i => ???
        case NotFound.i => ???
        case NotEnoughResources.i => ???
        case InvalidTarget.i => ???
        case NotInRange.i => creep.moveTo(target.pos)
        case Tired.i => ???
        case NoBodypart.i => ???
      }
      
    }
  }

  private def findClosestSource(creep: Creep): Option[Source] = {
    val findResult = creep.pos.findClosestByRange[Source](Find.SourcesActive)
    if(findResult.isDefined){
      Some(findResult.asInstanceOf[Source])
    }else{
      None
    }
  }

  
}
