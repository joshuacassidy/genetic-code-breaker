import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTests {

    Member member;

    @Before
    public void SetUp() {
        member = new Member();
        for (int i = 0; i < Keys.AMOUNT_OF_CHROMOSOMES; i++) {
            member.setGene(i, Keys.CODE.charAt(i));
        }
    }

    @Test
    public void getRandomGene() throws Exception {
        char gene = member.getRandomGene();
        assertEquals(true, ' ' <= gene && '~' >= gene);
    }

    @Test
    public void getFitness() throws Exception {
        assertEquals(Keys.MAX_FITNESS, member.getFitness());
    }

}