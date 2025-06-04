import sys


def solve():
    N, M = map(int, sys.stdin.readline().split())
    board = []
    for _ in range(N):
        board.append(sys.stdin.readline().strip())

    min_repaint_count = 64  # An 8x8 board has 64 cells, so max changes is 64

    # Iterate through all possible top-left corners of an 8x8 subgrid
    # r: starting row index for the 8x8 subgrid
    # c: starting column index for the 8x8 subgrid
    for r_start in range(N - 7):
        for c_start in range(M - 7):
            # Calculate repaints needed for two cases:
            # 1. Starting with 'W' in the top-left of the 8x8 subgrid
            # 2. Starting with 'B' in the top-left of the 8x8 subgrid

            repaint_count_W_start = 0
            repaint_count_B_start = 0

            # Iterate through the 8x8 subgrid
            for i in range(8):
                for j in range(8):
                    current_cell_color = board[r_start + i][c_start + j]

                    # Determine the expected color based on chessboard pattern
                    # A chessboard pattern alternates colors based on (row + col) sum parity
                    # If (row + col) is even, it's the same color as the top-left
                    # If (row + col) is odd, it's the opposite color of the top-left

                    # Case 1: Ideal board starts with 'W' at (r_start, c_start)
                    # For (i, j) within the 8x8 subgrid:
                    # If (i + j) is even, expected is 'W'
                    # If (i + j) is odd, expected is 'B'
                    if (i + j) % 2 == 0:  # Expected 'W'
                        if current_cell_color == 'B':
                            repaint_count_W_start += 1
                    else:  # Expected 'B'
                        if current_cell_color == 'W':
                            repaint_count_W_start += 1

                    # Case 2: Ideal board starts with 'B' at (r_start, c_start)
                    # For (i, j) within the 8x8 subgrid:
                    # If (i + j) is even, expected is 'B'
                    # If (i + j) is odd, expected is 'W'
                    if (i + j) % 2 == 0:  # Expected 'B'
                        if current_cell_color == 'W':
                            repaint_count_B_start += 1
                    else:  # Expected 'W'
                        if current_cell_color == 'B':
                            repaint_count_B_start += 1

            # Update the minimum repaint count found so far
            min_repaint_count = min(min_repaint_count, repaint_count_W_start, repaint_count_B_start)

    print(min_repaint_count)


if __name__ == "__main__":
    solve()