import org.junit.Before;

import static org.junit.Assert.*;

public class PopulationTests {

    Population population;
    Member member;

    @Before
    public void SetUP() {
        population = new Population(50);
        member = new Member();
        for (int i = 0; i < Keys.AMOUNT_OF_CHROMOSOMES; i++) {
            member.setGene(i, Keys.CODE.charAt(i));
        }
        population.saveIndividual(0, member);

    }

    @org.junit.Test
    public void getFittestMember() throws Exception {
        assertEquals(population.getFittestMember(), population.getMember(0));
    }

    @org.junit.Test
    public void size() throws Exception {
        assertEquals(50, population.size());
    }

    @org.junit.Test
    public void saveIndividual() throws Exception {
        assertArrayEquals(population.getMember(0).getGenes(),member.getGenes());
    }

    @org.junit.Test
    public void showFittestMember() throws Exception {
        assertEquals(Keys.CODE, population.showFittestMember());
    }

    @org.junit.Test
    public void getFittestMemberFitness() throws Exception {
        assertEquals(Keys.AMOUNT_OF_CHROMOSOMES, population.getMember(0).getFitness());
    }

}