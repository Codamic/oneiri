(ns oneiri.core
  (:require
   [hellhound.logger   :as log]
   [hellhound.core     :as hellhound]
   [oneiri.routes      :as router]
   [oneiri.events      :as events]
   [oneiri.subs        :as subs]
   [oneiri.views       :as views]))


(defn dev-setup [])

(defn ^:export init
  []
  (log/info "Starting HellHound application...")
  (hellhound/init!
   {:router           (router/app-routes)
    :dispatch-events  [:initialize-db]
    :dev-setup        dev-setup
    :main-view        views/main-panel}))
