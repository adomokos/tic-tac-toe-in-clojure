(ns tic-tac-toe.win
  (:require [clojure.set :only :map-invert]))

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

(defn winning-set [board]
  (let [moves (maps-winning-sets-to-moves board)
        mark-filter (fn [moves mark] (filter #(-> % val (= mark)) moves))
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
  [0 1])
