(ns oneiri.views.articles
  (:require [re-frame.core        :as re-frame]
            [oneiri.logger        :as logger]
            [oneiri.views.grommet :refer [title heading anchor glist list-item icon box paragraph]]
            [reagent.core         :as r]
            [hellhound.core       :refer [dispatch->server]]))

(def range (atom [0 10]))
(defn ask-for-more
  []
  (let [new-range (map #(+ % 10) @range)]
    (dispatch->server [:fetch-articles new-range])
    (swap! range (fn [_] new-range))))

(defn select-article
  [article]
  (re-frame/dispatch [:select-article article]))

(defn render-article
  "Render a single article"
  [article]
  (let [selected-id (re-frame/subscribe [:selected-article])]
    [list-item {:justify "between"} ^{:key (:id article)}
     [box
      [title
       (:title article)]
      [paragraph (:description article)]
      [anchor {:href  (:url article)
               :icon  (icon "LinkNext")
               :label "More"
               :target "_blank"
               :primary true}]]
     [box {:direction "row" :align "center"}
      (if (= @selected-id (:id article))
        [icon "Checkmark"])
      [anchor {:icon (icon "Like")}]]]))


(defn articles-list
  "This view is responsible for rendering a list of articles."
  []
  (let [articles (re-frame/subscribe [:recent-articles])]
      [box {:size :full :alignSelf :stretch}

       [box {:separator :bottom}
        [heading {:tag :h2}
         "Latest Stories"]]

       (if (empty? @articles)
         ;; If articles was empty
         [box {:size :full :alignSelf :stretch :pad :medium}
          [title "No recent topic has been found."]]
         ;; If articles was not empty
         [glist {:selectable true
                 :onSelect   select-article
                 :onMore     ask-for-more}

          (for [article @articles]
            ^{:key (:id article)} [render-article article])])]))
