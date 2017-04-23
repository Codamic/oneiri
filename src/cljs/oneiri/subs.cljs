(ns oneiri.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :lang
 (fn [db]
   (:lang db)))

(re-frame/reg-sub
 :active-panel
 (fn [db _]
   (:active-panel db)))
