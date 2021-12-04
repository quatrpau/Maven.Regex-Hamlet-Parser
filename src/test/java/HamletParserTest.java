import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String ham = "Hamlet";
        String expected = "Leon";
        String actual = hamletParser.changeHamToLeon(ham);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testChangeHamletToLeon2(){
        String hamCap = "HAMLET HAMLET";
        String expected = "LEON LEON";
        String actual = hamletParser.changeHamToLeon(hamCap);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testChangeHoratioToTariq() {
        String horat = "Horatio";
        String expected = "Tariq";
        String actual = hamletParser.changeHoratToTariq(horat);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testChangeHoratioToTariq2() {
        String horatCap = "HORATIO HORATIO";
        String expected = "TARIQ TARIQ";
        String actual = hamletParser.changeHoratToTariq(horatCap);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHoratio() {
        String horat = "fkdlsa;fjskaljfsjaflk;sadfjklas Horatio";
        String expected = "fkdlsa;fjskaljfsjaflk;sadfjklas Tariq";
        Assert.assertEquals(expected,hamletParser.changeHoratToTariq(horat));
    }
    @Test
    public void testFindHoratio2() {
        String expected = "dfs;lsaklfds;dsaj;fasd Hamlet";
        Assert.assertEquals(expected,hamletParser.changeHoratToTariq(expected));
    }
    @Test
    public void testFindHamlet() {
        String ham = "dsjfalsjflksd;ajkf;sad;fdsafjkdsa;jf;dajk;fadf Hamlet";
        String expected = "dsjfalsjflksd;ajkf;sad;fdsafjkdsa;jf;dajk;fadf Leon";
        Assert.assertEquals(expected,hamletParser.changeHamToLeon(ham));

    }
    @Test
    public void testFindHamlet2() {
        String expected = "adffdsafadsfsdad";
        Assert.assertEquals(expected,hamletParser.changeHamToLeon(expected));
    }
}