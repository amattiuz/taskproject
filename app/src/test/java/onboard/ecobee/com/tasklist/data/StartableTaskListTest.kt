package onboard.ecobee.com.tasklist.data

import org.junit.Before
import org.junit.Test

class StartableTaskListTest {

    internal var startableTaskList = StartableTaskList()

    @Before
    fun setUp(){
        startableTaskList.start()
    }

    @Test
    fun `task_list_shoulb_be_initialized_with_single_list`() {
       testAllTasks().assertValueCount(1)
    }

    @Test
    fun `when a task is added to the list, then it is reported at the end of the list` (){
        val testObserver = testAllTasks()

        val task = createTask()
        startableTaskList.createNewTask(task)

        testObserver.assertValueAt(1, { it.last() == task })
    }

   @Test
    fun `when two tasks with the same id are added, then only the last one should be on the list`(){
       val task1 = createTask(title = "something")
       val task2 = createTask(title = "title 2")
       startableTaskList.createNewTask(task1)
       startableTaskList.createNewTask(task2)
       testAllTasks().assertValue( { it.contains(task2) && !it.contains(task1)})
   }

    @Test
    fun `when two tasks with the different ids are added, then both should be on the list`(){
        val task1 = createTask(title = "something")
        val task2 = createTask(id = 2, title = "title 2")
        startableTaskList.createNewTask(task1)
        startableTaskList.createNewTask(task2)
        testAllTasks().assertValue( { it.contains(task2) && it.contains(task1)})
    }

    private fun createTask(id: Long = 3, title: String = "title") =  Task(id,title,"my test description",0 )

    private fun testAllTasks() = startableTaskList.allTasks.test()

}