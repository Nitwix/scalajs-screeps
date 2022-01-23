package com.squid314.screeps.scheduling

import com.screeps.native.Creep
import com.screeps.native.StructureSpawn
import com.screeps.native.RoomObject

/** A scheduler decides which tasks are executed when. The type parameter
  * specifies the type of the execution units.
  */
trait Scheduler[EU <: RoomObject] {

  /** Add a task to be scheduled.
    *
    * @param t
    *   Task to be scheduled
    */
  def addTask[T <: Task](t: T): Unit

  /** Tries to dispatch a task from the task list to one of creeps. If
    * successful, the dispatched task is removed from the task list, and
    * returned.
    *
    * @param eus
    *   List of the available execution units
    * @return
    *   Dispatched task, if the dispatching succeeded
    */
  def dispatchTask(eus: List[ExecutionUnit[EU]]): Option[Task]

  /** Updates all tasks, if needed. This must be called each tick to allow the
    * scheduler to update its tasks if it wants to do so.
    */
  def updateTasks(): Unit = {}
}
