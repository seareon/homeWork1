package com.seraeon;

import com.seraeon.util.MyXMLReader;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Misha Ro on 11.12.2016.
 */
public class BeelineTest {
    @Test
    public void makeTwoPointsOfBeeline() {
        Beeline line = (Beeline) MyXMLReader.readXML("line", "line1test1");

        Double a = (Double) MyXMLReader.readXML("expected", "expected1test1");
        Double b = (Double) MyXMLReader.readXML("expected", "expected2test1");
        Double c = (Double) MyXMLReader.readXML("expected", "expected3test1");

        Assert.assertEquals(a, line.getA(), 0.01);
        Assert.assertEquals(b, line.getB(), 0.01);
        Assert.assertEquals(c, line.getC(), 0.01);
    }

    @Test
    public void calculateAngleBetweenLines() throws Exception {         // are these lines  parallel?
        Beeline line1 = (Beeline) MyXMLReader.readXML("line", "line1test2");
        Beeline line2 = (Beeline) MyXMLReader.readXML("line", "line2test2");

        Double expected = (Double) MyXMLReader.readXML("expected", "expected1test2");
        double actual = line1.calculateAngleBetweenLines(line2);

        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void calculateAngleBetweenLines2() throws Exception {         // are these lines  parallel?
        Beeline line1 = (Beeline) MyXMLReader.readXML("line", "line1test3");
        Beeline line2 = (Beeline) MyXMLReader.readXML("line", "line2test3");

        Double expected = (Double) MyXMLReader.readXML("expected", "expected1test3");
        double actual = line1.calculateAngleBetweenLines(line2);

        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void axisCrossAtRightAngles() throws Exception {             // the axis Ox cross at right angles
        Beeline line1 = (Beeline) MyXMLReader.readXML("line", "line1test4");
        Beeline line2 = (Beeline) MyXMLReader.readXML("line", "line2test4");

        Double expected = (Double) MyXMLReader.readXML("expected", "expected1test4");
        double actual = line1.calculateAngleBetweenLines(line2);

        Assert.assertEquals(expected, actual, 0.01);
    }


    @Test
    public void axisCrossAtRightAngles2() throws Exception {             // the axis Ox cross at right angles
        Beeline line1 = (Beeline) MyXMLReader.readXML("line", "line1test5");
        Beeline line2 = (Beeline) MyXMLReader.readXML("line", "line2test5");

        Double expected = (Double) MyXMLReader.readXML("expected", "expected1test5");
        double actual = line1.calculateAngleBetweenLines(line2);

        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void axisCrossAtRightAngles3() throws Exception {             // the axis Ox cross at right angles
        Beeline line1 = (Beeline) MyXMLReader.readXML("line", "line1test6");
        Beeline line2 = (Beeline) MyXMLReader.readXML("line", "line2test6");

        Double expected = (Double) MyXMLReader.readXML("expected", "expected1test6");
        double actual = line1.calculateAngleBetweenLines(line2);

        Assert.assertNotEquals(expected, actual, 0.01);
    }

    @Test
    public void axisCrossAtRightAngles4() throws Exception {             // the axis Ox cross at right angles
        Beeline line1 = (Beeline) MyXMLReader.readXML("line", "line1test7");
        Beeline line2 = (Beeline) MyXMLReader.readXML("line", "line2test7");

        Double expected = (Double) MyXMLReader.readXML("expected", "expected1test7");
        double actual = line1.calculateAngleBetweenLines(line2);

        Assert.assertNotEquals(expected, actual, 0.01);
    }

    @Test
    public void calculateDistanceBetweenParallelLines1() throws Exception {
        Beeline line1 = (Beeline) MyXMLReader.readXML("line", "line1test8");
        Beeline line2 = (Beeline) MyXMLReader.readXML("line", "line2test8");

        Double expected = (Double) MyXMLReader.readXML("expected", "expected1test8");
        double actual = line1.calculateDistanceBetweenParallelLines(line2);

        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void calculateDistanceBetweenParallelLines2() throws Exception {     // these line aren't parallel
        Beeline line1 = (Beeline) MyXMLReader.readXML("line", "line1test9");
        Beeline line2 = (Beeline) MyXMLReader.readXML("line", "line2test9");

        Double expected = (Double) MyXMLReader.readXML("expected", "expected1test9");
        double actual = line1.calculateDistanceBetweenParallelLines(line2);

        Assert.assertNotEquals(expected, actual, 0.01);
    }
}