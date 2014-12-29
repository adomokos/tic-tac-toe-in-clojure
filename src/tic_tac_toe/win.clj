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

(defn maps-winning-sets-to-moves [board]
  (let [finds-user-value (fn [coordinate]
                              (-> board
                                 (nth (first coordinate))
                                 (nth (last coordinate))))]
    (map (fn [row]
           (into {} (map #(conj [%] (finds-user-value %)) row)))
         winning-sets)))

(defn- mark-filter [moves mark]
  (filter #(-> % val (= mark)) moves))


(defn winning-set [board]
  (let [moves (maps-winning-sets-to-moves board)
        first-win (fn [mark]
                    (first (filter #(= 3 (count %))
                                   (map #(-> % (into {}) keys vec)
                                        (map #(mark-filter % mark) moves)))))
        first-x-win (first-win :X)
        first-o-win (first-win :O)]
    (cond
      (not (= nil first-x-win)) {:X first-x-win}
      (not (= nil first-o-win)) {:O first-o-win}
      :else nil)))

(defn has-winner? [board]
  (not (= nil (winning-set board))))

(defn best-move [board]
  (let [moves (maps-winning-sets-to-moves board)
        number-of-moves-in-winning-set (fn [mark]
                                         (map #(count (mark-filter % mark)) moves))
        number-of-moves-for-winning-sets (map list winning-sets (number-of-moves-in-winning-set :X))
        most-likely-winning-set (-> (sort-by last number-of-moves-for-winning-sets) reverse first)
        index-of-winning-set (.indexOf winning-sets (first most-likely-winning-set))
        winning-set-in-moves (nth moves index-of-winning-set)]
    (cond
      (= :_ (last (first winning-set-in-moves))) (first (first winning-set-in-moves))
      (= :_ (last (second winning-set-in-moves))) (first (second winning-set-in-moves))
      :else
        (first (last winning-set-in-moves)))))
