package test.developer;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class TaskManagerTest {

    @Test
    public void makeTask() {
        Task myTask = TaskManager.makeTask("Me");
        assertEquals(
                new SimpleDateFormat("dd.MM.YYYY").format(new Date()),
                new SimpleDateFormat("dd.MM.YYYY").format(myTask.getStartDate())
        );
        myTask.setEndDate(new Date(1421893256000L));
        assertEquals(
                new SimpleDateFormat("dd.MM.YYYY").format(new Date(1421893256000L)),
                new SimpleDateFormat("dd.MM.YYYY").format(myTask.getEndDate())
        );
    }
}