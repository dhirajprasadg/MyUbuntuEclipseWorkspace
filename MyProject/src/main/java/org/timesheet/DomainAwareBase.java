package org.timesheet;
 
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.jdbc.JdbcTestUtils;
 
/**
 * Base makes sure that before any test empty database is available.
 */
@ContextConfiguration(locations = {"/persistence-beans.xml"})
public abstract class DomainAwareBase extends AbstractJUnit4SpringContextTests {
 
    private final String deleteScript = "resources/sql/cleanup.sql";
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
 
    @Before
    public void deleteAllDomainEntities() {
        JdbcTestUtils.executeSqlScript(jdbcTemplate,
                new FileSystemResource(deleteScript), false);
    }
}