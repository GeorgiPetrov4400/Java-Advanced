package ExamPreparation062022.guild88_03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> playersToRemove = this.roster.stream().filter(s -> s.getClazz().equals(clazz)).collect(Collectors.toList());
        this.roster.removeAll(playersToRemove);
        return playersToRemove.toArray(Player[]::new);
//        List<Player> kickedPlayers = new ArrayList<>();
//        for (Player player : roster) {
//            if (player.getClazz().equals(clazz)) {
//                kickedPlayers.add(player);
//                roster.remove(player);
//            }
//        }
//        return kickedPlayers.toArray(Player[]::new);
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(String.format("Players in the guild: %s:", this.name)).append("\n");
        for (Player player : roster) {
            sb.append(player.toString());
        }
        return sb.toString();
    }
}
