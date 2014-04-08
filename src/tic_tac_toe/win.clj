(ns tic-tac-toe.win)

(defonce winning-sets
  [[[0 0] [0 1] [0 2]]
   [[1 0] [1 1] [1 2]]
   [[2 0] [2 1] [2 2]]
   [[0 0] [1 0] [2 0]]
   [[0 1] [1 1] [2 1]]
   [[0 2] [1 2] [2 2]]
   [[0 0] [1 1] [2 2]]
   [[0 2] [1 1] [2 0]]
   ])

(defn has-winner? [board]
  {:X [[0 0] [0 1] [0 2]]})

(defn best-move [board]
  [0 1])
