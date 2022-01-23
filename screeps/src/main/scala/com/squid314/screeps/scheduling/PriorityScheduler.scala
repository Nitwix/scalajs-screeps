package com.squid314.screeps.scheduling

import com.screeps.native.RoomObject
import scala.collection.mutable.ListBuffer


class PriorityScheduler[T <: RoomObject](currentTasks: Set[PriorityTask])
extends Scheduler[T] {
  /** PriorityTask
    *
    * @param priority
    *   Priority of the task, bigger means more urgent. Must be >0
    * @param priorityPoints
    *   Current number of priority points the task has accumulated. At each
    *   update, this number number increases proportionnaly to the priority. This
    *   avoids starvation of low priority tasks.
    */
  case class PriorityTask(priority: Int, priorityValue: Int) extends Task {
    assert(priority > 0, "The priority of a task cannot be negative")
  }
  private var tasks: Set[PriorityTask] = currentTasks
  override def addTask[PriorityTask](t: PriorityTask): Unit = {
    tasks = tasks + t
  }
  override def dispatchTask(eus: List[ExecutionUnit[T]]): Option[Task] = ???

  override def updateTasks(): Unit = ???
}
