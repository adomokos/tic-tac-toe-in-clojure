(ns tic-tac-toe.win-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.win :refer :all]))

(deftest maps-winning-sets-to-moves-test
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

(deftest can-tell-if-there-is-a-winner
  (testing "spots a winner for the first line for X"
    (let [board [[:X :X :X] [:O :O :_] [:_ :_ :_]]]
      (is (has-winner? board))))
  (testing "spots a winner for the second line for O"
    (let [board [[:X :X :O] [:O :O :O] [:_ :_ :_]]]
      (is (has-winner? board))))
  (testing "no winner just yet"
    (let [board [[:O :O :X] [:X :X :_] [:_ :_ :_]]]
      (is (not (has-winner? board))))))

(deftest finds-the-winning-set
  (testing "finds the winning set for the first line for X"
    (let [board [[:X :X :X] [:O :O :_] [:_ :_ :_]]]
      (is (= {:X [[0 0] [0 1] [0 2]]} (winning-set board)))))
  (testing "finds the winning set for the bottom-left top-right diagonal for X"
    (let [board [[:O :O :X] [:O :X :_] [:X :_ :_]]]
      (is (= {:X [[0 2] [1 1] [2 0]]} (winning-set board)))))
  (testing "finds the winning set for the second line for O"
    (let [board [[:X :X :O] [:O :O :O] [:_ :_ :_]]]
      (is (= {:O [[1 0] [1 1] [1 2]]} (winning-set board)))))
  (testing "no winner just yet"
    (let [board [[:X :X :O] [:X :O :O] [:_ :_ :_]]]
      (is (= nil (winning-set board))))))

(deftest suggest-a-best-move
  (testing "it's easy when there is only one move"
    (let [board [[:X :_ :_] [:_ :_ :_] [:_ :_ :_]]]
      (is (= [0 1] (best-move board))))))
  ;(testing "tries to stop the diagonal"
    ;(let [board [[:X :O :_] [:_ :X :_] [:_ :_ :_]]]
      ;(is (= [2 2] (best-move board))))))
