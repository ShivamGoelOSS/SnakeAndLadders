package src;

public class BoardFactory {
	public Board createBoard(int size, int numLadders, int numSnakes) {
		IBoardEntity[][] boardEntities = new IBoardEntity[size][size];
		int totalCells = size * size;
		java.util.Random random = new java.util.Random();
		boolean[] usedStarts = new boolean[totalCells + 1];

		// Random ladders (start < end)
		for (int i = 0; i < numLadders; i++) {
			int attempts = 0;
			while (attempts++ < totalCells * 2) {
				int start = 1 + random.nextInt(totalCells - 1); // 1..total-1
				if (usedStarts[start]) continue;
				int end = start + 1 + random.nextInt(totalCells - start); // (start+1)..total
				int zero = start - 1;
				int row = zero / size;
				int col = zero % size;
				boardEntities[row][col] = new LadderEntity(start, end);
				usedStarts[start] = true;
				break;
			}
		}

		// Random snakes (start > end)
		for (int i = 0; i < numSnakes; i++) {
			int attempts = 0;
			while (attempts++ < totalCells * 2) {
				int start = 2 + random.nextInt(totalCells - 1); // 2..total
				if (usedStarts[start]) continue;
				int end = 1 + random.nextInt(start - 1); // 1..(start-1)
				int zero = start - 1;
				int row = zero / size;
				int col = zero % size;
				boardEntities[row][col] = new SnakeEntity(start, end);
				usedStarts[start] = true;
				break;
			}
		}

		return new Board(size, boardEntities);
	}
}
