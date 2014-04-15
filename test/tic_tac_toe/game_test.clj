(ns tic-tac-toe.game-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.game :refer :all]))

(deftest board-test
  (is (= [[:_ :_ :_][:_ :_ :_][:_ :_ :_]] board)))

(deftest print-board-test
  (testing "prints an empty tic-tac-toe board"
    (is (= "\n_ _ _ \n_ _ _ \n_ _ _ \n" (print-board board)))))

(deftest converts-step-into-coordinates-test
  (testing "A1 is [0 0]"
    (is (= [0 0] (converts-step-into-coordinates "A1"))))
  (testing "A2 is [0 1]"
    (is (= [0 1] (converts-step-into-coordinates "A2"))))
  (testing "C3 is [2 2]"
    (is (= [2 2] (converts-step-into-coordinates "C3"))))
  (testing "C4 is throwing an IllegalArgumentException"
    (is (thrown? IllegalArgumentException (converts-step-into-coordinates "C4"))))
  (testing "D3 is throwing an IllegalArgumentException"
    (is (thrown? IllegalArgumentException (converts-step-into-coordinates "D3")))))

(deftest user-moves-tests
  (let [game-board (atom board)]
    (testing "for user - A1 marks the top left with `X`"
      (is (= [[:X :_ :_][:_ :_ :_][:_ :_ :_]] (swap! game-board record-user-move "A1"))))
    (testing "for computer - B2 marks the middle with `X`"
      (is (= [[:X :_ :_][:_ :X :_][:_ :_ :_]] (swap! game-board record-user-move "B2"))))
    (testing "for user - C3 marks the bottom right with `X`"
      (is (= [[:X :_ :_][:_ :X :_][:_ :_ :X]] (swap! game-board record-user-move "C3"))))))

(deftest computer-moves-test
  (let [game-board (atom board)]
    (testing "computer's first move"
      (do
        (swap! game-board record-user-move "A1")
        (is (= [[:X :_ :_][:_ :O :_][:_ :_ :_]] (swap! game-board record-computer-move)))))))
    ;(testing "computer's second move"
      ;(do
        ;(swap! game-board record-user-move "A3")
        ;(is (= [[:X :O :X][:O :_ :_][:_ :_ :_]] (swap! game-board record-computer-move)))))))
