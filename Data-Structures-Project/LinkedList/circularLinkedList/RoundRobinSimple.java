class Process {
    int id;
    Process next;

    public Process(int id) {
        this.id = id;
    }
}

public class RoundRobinSimple {

    Process head = null;

    public void addProcess(int id) {
        Process newProcess = new Process(id);

        if (head == null) {
            head = newProcess;
            head.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    public void execute(int rounds) {
        Process temp = head;

        for (int i = 0; i < rounds; i++) {
            System.out.println("Executing Process: " + temp.id);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        RoundRobinSimple rr = new RoundRobinSimple();
        rr.addProcess(1);
        rr.addProcess(2);
        rr.addProcess(3);
        rr.execute(6);
    }
}