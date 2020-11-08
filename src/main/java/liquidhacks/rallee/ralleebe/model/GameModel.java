package liquidhacks.rallee.ralleebe.model;

import java.util.List;

class GameModel {
	private String name;
	//private List<AvailabilityDays> availability;
	private boolean isCompetitive;
	private boolean isCasual;
	private int rank;
	private List<String> gamePositions;
	
	public GameModel() {
		
	}
	
	public GameModel(String name, boolean isCompetitive, boolean isCasual) {
		super();
		this.name = name;
		//this.availability = availability;
		this.isCompetitive = isCompetitive;
		this.isCasual = isCasual;
		this.rank = rank;
		this.gamePositions = gamePositions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<AvailabilityDays> getAvailability() {
//		return availability;
//	}
//
//	public void setAvailability(List<AvailabilityDays> availability) {
//		this.availability = availability;
//	}

	public boolean isCompetitive() {
		return isCompetitive;
	}

	public void setCompetitive(boolean isCompetitive) {
		this.isCompetitive = isCompetitive;
	}

	public boolean isCasual() {
		return isCasual;
	}

	public void setCasual(boolean isCasual) {
		this.isCasual = isCasual;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public List<String> getGamePositions() {
		return gamePositions;
	}

	public void setGamePositions(List<String> gamePositions) {
		this.gamePositions = gamePositions;
	}
}