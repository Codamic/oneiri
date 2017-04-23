(ns oneiri.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [oneiri.core-test]))

(doo-tests 'oneiri.core-test)
