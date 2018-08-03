import java.util.ArrayList;
import java.util.Random;

public class CodeBreaker {

    private Random random;

    public CodeBreaker() {
        random = new Random();
    }

    public Population evolvePopulation(Population population) {
        Population nextGeneration = new Population(population.size());

        for (int i = 0; i < population.size(); i++) {
            Member parent1 = selectFittest(population);
            Member parent2 = selectFittest(population);
            Member child = crossover(parent1, parent2);
            nextGeneration.saveIndividual(i, child);
        }

        for (int i = 0; i < nextGeneration.size(); i++) {
            mutate(nextGeneration.getMember(i));
        }
        return nextGeneration;
    }


    private void mutate(Member member) {
        for (int i = 0; i < Keys.AMOUNT_OF_CHROMOSOMES; i++) {
            if (Math.random() < Keys.MUTATION_RATE) {
                member.setGene(i, member.getRandomGene());
            }
        }
    }

    private Member crossover(Member parent1, Member parent2) {
        Member child = new Member();
        for (int i = 0; i < Keys.AMOUNT_OF_CHROMOSOMES; i++) {
            if (Math.random() < Keys.CROSSOVER_RATE) {
                child.setGene(i, parent1.getGene(i));
            } else {
                child.setGene(i, parent2.getGene(i));
            }
        }
        return child;
    }

    public Member selectFittest(Population population) {

        ArrayList<Member> members = membersPool(population);
        Population sample = new Population(Keys.SAMPLE_SIZE);
        for (int i = 0; i < Keys.SAMPLE_SIZE; i++) {
            int randomIndex = random.nextInt(members.size());
            sample.saveIndividual(i, members.get(randomIndex));
            members.remove(randomIndex);
        }

        return sample.getFittestMember();

    }

    private ArrayList<Member> membersPool(Population population) {
        ArrayList<Member> members = new ArrayList<>();
        for (Member member: population.getMembers()) {
                members.add(member);
        }
        return members;
    }

}
