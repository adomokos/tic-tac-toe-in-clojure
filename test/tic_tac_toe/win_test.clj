(ns tic-tac-toe.win-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.win :refer :all]))

(deftest converts-board-to-moves-test
  (let [board [[:X :X :O] [:O :O :X] [:X :O :_]]]
    (is (= [{[0 0] :X [0 1] :X [0 2] :O}
            {[1 0] :O [1 1] :O [1 2] :X}
            {[2 0] :X [2 1] :O [2 2] :_}
            {[0 0] :X [1 0] :O [2 0] :X}
            {[0 1] :X [1 1] :O [2 1] :O}
            {[0 2] :O [1 2] :X [2 2] :_}
            {[0 0] :X [1 1] :O [2 2] :_}
            {[0 2] :O [1 1] :O [2 0] :X}]
           (maps-winning-sets-to-moves board)))))

;(deftest finds-winner-test
  ;(testing "spots a winner for the first line"
    ;(let [board [[:X :X :X] [:O :O :_] [:_ :_ :_]]]
    ;(is (= {:X [[0 0] [0 1] [0 2]]} (has-winner? board))))
    ;(let [board [[:O :O :O] [:X :X :_] [:_ :_ :_]]]
    ;(is (= {:O [[0 0] [0 1] [0 2]]} (has-winner? board))))))
