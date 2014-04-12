(ns tic-tac-toe.win)

(defonce winning-sets
  [[[0 0] [0 1] [0 2]]
   [[1 0] [1 1] [1 2]]
   [[2 0] [2 1] [2 2]]
   ;[[0 0] [1 0] [2 0]]
   ;[[0 1] [1 1] [2 1]]
   ;[[0 2] [1 2] [2 2]]
   ;[[0 0] [1 1] [2 2]]
   ;[[0 2] [1 1] [2 0]]
   ])

(defn converts-board-to-moves [board]
  (let [finds-user-value (fn [coordinate]
                              (-> board
                                 (nth (first coordinate))
                                 (nth (last coordinate))))]
    (map (fn [row]
           (into {} (map #(conj [%] (finds-user-value %)) row)))
         winning-sets)
    ))

(def moves
  [{[0 0] :X [0 1] :O [0 2] :_}
   {[1 0] :X [1 1] :X [1 2] :_}
   {[2 0] :_ [2 1] :_ [2 2] :_}]
  )

(defn has-winner? [board]
  {:X [[0 0] [0 1] [0 2]]})

(defn best-move [board]
  [0 1])
