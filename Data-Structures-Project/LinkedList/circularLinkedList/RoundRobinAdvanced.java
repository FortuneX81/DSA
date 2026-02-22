class AdvancedProcess {
    int id;
    int time;
    AdvancedProcess next;

    public AdvancedProcess(int id, int time) {
        this.id = id;
        this.time = time;
    }
}

public class RoundRobinAdvanced {

    AdvancedProcess head = null;

    public void addProcess(int id, int time) {
        AdvancedProcess newProcess = new AdvancedProcess(id, time);

        if (head == null) {
            head = newProcess;
            head.next = head;
        } else {
            AdvancedProcess temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    public void execute() {
        AdvancedProcess temp = head;

        do {
            System.out.println("Executing Process: " + temp.id);
            temp.time--;
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        RoundRobinAdvanced rr = new RoundRobinAdvanced();
        rr.addProcess(1, 3);
        rr.addProcess(2, 2);
        rr.execute();
    }
}