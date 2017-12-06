package onboard.ecobee.com.tasklist.tasks

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.stub
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import onboard.ecobee.com.tasklist.data.Task
import onboard.ecobee.com.tasklist.data.TaskList
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit


class TaskListPresenterTest {

    @JvmField
    @Rule
    var mockitoRule = MockitoJUnit.rule()

    @Mock private lateinit var view: TaskListView
    @Mock private lateinit var datasource: TaskList

    private lateinit var presenter: TaskListPresenter

    @Before
    fun setUpPresenter() {
        stubFabClicks()
        stubDataSource()
        stubTaskClicks()
        presenter = TaskListPresenter(view, datasource)
    }

    @Test
    fun `when presenter is started view is also started`() {
        presenter.start()
        verify(view).start()
    }

    @Test
    fun `when fab is clicked task detail screen opens`() {
        stubFabClicks(Observable.just(Any()))
        presenter.start()
        verify(view).goToTaskDetail(anyLong())
    }

    @Test
    fun `when the presenter is started, the list of all tasks is shown`() {
        val tasklist = listOf(Task(1, "title", "description", 0))
        stubDataSource(Observable.just(tasklist))
        stubTaskClicks(tasks = tasklist)
        presenter.start()
        verify(view).showTasks(tasklist)
    }

    @Test
    fun `when tasks are updated, given presenter has started, then tasks are shown`() {
        val tasklist = listOf(Task(1, "title", "description", 0))
        val tasksubject = PublishSubject.create<List<Task>>()
        stubDataSource(tasksubject)
        stubTaskClicks(tasks = tasklist)
        presenter.start()
        tasksubject.onNext(tasklist)
        verify(view).showTasks(tasklist)
    }

    @Test
    fun `when a task is clicked, the details screen of that task opens`() {
        val task = Task(1, "title", "description", 0)
        stubDataSource(Observable.just(listOf(task)))
        stubTaskClicks(Observable.just(task), listOf(task))
        presenter.start()
        verify(view).goToTaskDetail(1)
    }


    private fun stubFabClicks(clicks: Observable<Any> = Observable.empty())
            = view.stub { on { getFabClicks() } doReturn clicks }

    private fun stubTaskClicks(clicks: Observable<Task> = Observable.empty(), tasks: List<Task>
            = emptyList()) = view.stub { on { showTasks(tasks) } doReturn clicks }

    private fun stubDataSource(source: Observable<List<Task>> = Observable.empty()) = datasource.stub { on { allTasks } doReturn source }

}