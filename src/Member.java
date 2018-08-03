import java.util.Random;

public class Member {

    private char[] genes;
    private int fitness;
    private Random random;

    public Member() {
        this.genes = new char[Keys.AMOUNT_OF_CHROMOSOMES];
        this.random = new Random();
    }

    public void generateMember() {
        for (int i = 0; i < Keys.AMOUNT_OF_CHROMOSOMES; i++) {
            genes[i] = getRandomGene();
        }
    }

    public char getRandomGene() {
        return (char) (random.nextInt('z' -  ' ' + 1) + ' ');
    }

    public int getFitness() {
        if (fitness == 0) {
            for (int i = 0; i < Keys.AMOUNT_OF_CHROMOSOMES; i++) {
                if (genes[i] == Keys.CODE.charAt(i)) {
                    this.fitness++;
                }
            }
        }
        return fitness;
    }

    public char getGene(int index) {
        return this.genes[index];
    }

    public void setGene(int index, char value) {
        this.genes[index] = value;
        fitness = 0;
    }

    @Override
    public String toString() {
        String membersGenes = "";
        for (char gene: genes) {
            membersGenes+=gene;
        }
        return membersGenes;
    }

    public char[] getGenes() {
        return genes;
    }
}
