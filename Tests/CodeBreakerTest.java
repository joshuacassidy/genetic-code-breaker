import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CodeBreakerTest {

    CodeBreaker codeBreaker;
    Population population;

    @Before
    public void setUp() throws Exception {
        population = new Population(5);
        codeBreaker = new CodeBreaker();
    }

    @Test
    public void evolvePopulation() throws Exception {
        Population nextGeneration = codeBreaker.evolvePopulation(population);
        assertEquals(true, nextGeneration.getFittestMember().getFitness() >= population.getFittestMember().getFitness());
    }

    @Test
    public void randomSelection() throws Exception {
        Member member = new Member();
        for (int i = 0; i < Keys.AMOUNT_OF_CHROMOSOMES; i++) {
            member.setGene(i, Keys.CODE.charAt(i));
        }
        population.saveIndividual(0, member);
        assertEquals(member, codeBreaker.selectFittest(population));
    }

}