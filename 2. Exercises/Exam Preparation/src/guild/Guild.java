package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        //  int index = findPlayerIndex(name);
//
        //  if (index != -1) {
        //      roster.remove(index);
        //      return true;
        //  }
        //  return false;

        Player player = roster.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (player != null) {
            roster.remove(player);
            return true;
        }
        return false;
    }

    public void promotePlayer(String name) {
        int index = findPlayerIndex(name);
        if (index != -1) {
            roster.get(index).setRank("Member");
        }
    }

    public void demotePlayer(String name) {
        int index = findPlayerIndex(name);
        if (index != -1) {
            roster.get(index).setRank("Trial");
        }
    }


    public Player[] kickPlayersByClass(String clazz) {
        int count = 0;
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                count++;
            }
        }
//
        Player[] kickPlayers = new Player[count];
        int s = 0;
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                kickPlayers[s++] = player;
            }
        }
//
        for (Player kickPlayer : kickPlayers) {
            roster.remove(kickPlayer);
        }
        return kickPlayers;

        //  List<Player> removedPlayers = roster.stream()
        //          .filter(e -> e.getName().equals(clazz))
        //          .collect(Collectors.toList());

        //  roster.removeAll(removedPlayers);

        //  return removedPlayers.toArray(Player[]::new);

    }

    public int count() {
        return this.roster.size();
    }

// On Exam print exactly the same!
    public String report() {

        return String.format("Players in the guild: %s:%n%s", name,
                roster.stream()
                        .map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .trim();
        //  StringBuilder b = new StringBuilder();
        //  b.append("Players in the guild: ").append(this.name).append(":").append(System.lineSeparator());
        //  for (Player player : roster) {
        //      b.append(player.toString()).append(System.lineSeparator());
        //  }
        //  return b.toString().trim();
    }

    private int findPlayerIndex(String name) {
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
