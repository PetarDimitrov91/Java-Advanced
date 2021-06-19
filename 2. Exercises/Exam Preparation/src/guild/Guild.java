package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        if (this.roster.size() > 0) {
            for (Player player : roster) {
                if (player.getName().equals(name)) {
                    return this.roster.remove(player);
                }
            }
        }
        return false;
    }

    // Възможна грешка!
    public void promotePlayer(String name) {
        if (this.roster.size() > 0) {
            for (Player player : roster) {
                if (player.getName().equals(name)) {
                    if (!player.getRank().equals("Member")) {
                        player.setRank("Member");
                        break;
                    }
                }
            }
        }
    }

    // Възможна грешка!
    public void demotePlayer(String name) {
        if (this.roster.size() > 0) {
            for (Player player : roster) {
                if (player.getName().equals(name)) {
                    if (!player.getRank().equals("Trail")) {
                        player.setRank("Trail");
                        break;
                    }
                }
            }
        }
    }
    // Възможна грешка!
    public Player[] kickPlayersByClass(String clazz) {
        int count = 0;
        if (this.roster.size() > 0) {
            for (Player player : roster) {
                if (player.getClazz().equals(clazz)) {
                    count++;
                }
            }
        }
        Player[] kickPlayers = new Player[count];
        int s = 0;
        if (this.roster.size() > 0) {
            for (Player player : roster) {
                if (player.getClazz().equals(clazz)) {
                    kickPlayers[s] = player;
                    s++;
                }
            }
        }
        this.roster.removeIf(e -> e.getClazz().equals(clazz));
        return kickPlayers;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder b = new StringBuilder();
        b.append("Players in the guild: ").append(this.name).append(":").append(System.lineSeparator());
        for (Player player : roster) {
            b.append(player.toString()).append(System.lineSeparator());
        }
        return b.toString();
    }
}
