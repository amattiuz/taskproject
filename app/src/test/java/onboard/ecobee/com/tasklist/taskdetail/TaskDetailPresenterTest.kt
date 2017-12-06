package onboard.ecobee.com.tasklist.taskdetail

import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import onboard.ecobee.com.tasklist.data.TaskList
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit
import org.mockito.stubbing.Answer


class TaskDetailPresenterTest {

    @JvmField @Rule
    var mockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var view : TaskDetailView
    @Mock
    private lateinit var datasource : TaskList

    private lateinit var presenter : TaskDetailPresenter

    @Before
    fun setUp() {
        presenter = TaskDetailPresenter(view, datasource, 12345)
    }

    @Test
    fun `when presenter starts view is also tarted`(){
        mockDataSource()
        mockEmptyClickListeners()
        presenter.start()
        verify(view).start()
    }

    @Test
    fun `when new task event arrives new task is created at datasource`(){
        mockDataSource()
        mockClickListersWithValue()
        presenter.start()
        verify(datasource).createNewTask(ArgumentMatchers.any())
    }

    @Test
    fun `when set date event arrives show date picker`(){
        mockDataSource()
        mockClickListersWithValue()
        presenter.start()
        verify(view).showDatePickerDialog()
    }

    private fun mockClickListersWithValue(){
        `when`(view.listenToCreateTaskClicks()).thenReturn(Observable.just(true))
        `when`(view.listenToTaskDateChanges()).thenReturn(PublishSubject.create())
        `when`(view.listenToSetDateClicks()).thenReturn(Observable.just(true))
    }

    private fun mockEmptyClickListeners(){
        `when`(view.listenToCreateTaskClicks()).thenReturn(Observable.empty())
        `when`(view.listenToTaskDateChanges()).thenReturn(PublishSubject.create())
        `when`(view.listenToSetDateClicks()).thenReturn(Observable.empty())
    }

    private fun mockDataSource(){
        `when`(datasource.allTasks).thenReturn(Observable.empty())
        `when`(datasource.createNewTask(ArgumentMatchers.any())).thenAnswer(Answer {  })
    }





}