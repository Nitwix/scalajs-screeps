package com.squid314.screeps.scheduling

import com.screeps.native.RoomObject

/**
  * An ExecutionUnit is an object which can execute a task dispatched by the scheduler.
  * The underlying executor is a screeps object, for example a Creep, a Spawner, ...
  */
trait ExecutionUnit[T <: RoomObject] {
  /**
    * Carries out a task in the screeps world.
    */
  val executor: T
}
