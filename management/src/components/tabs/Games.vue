<template>
    <div>
        <br/><b-button pill @click="sync" variant="primary">Refresh</b-button><br/><br/>
        <b-progress id="progress" class="mt-2" :max="games.length" show-value>
            <b-progress-bar :value="games.length - Math.ceil(arbitrages.length*10/games.length)" variant="warning"></b-progress-bar>
            <b-progress-bar :value="Math.ceil(arbitrages.length*10/games.length)" variant="success"></b-progress-bar>
        </b-progress>
        <br/><br/>
        <b-table id="games-table" striped hover @row-selected="onRowSelected" :select-mode="selectMode" :sort-desc.sync="sortDesc" :sort-by.sync="sortBy" :current-page="currentPage" :per-page="perPage" :items="games" :fields="fields"></b-table>
        <b-pagination
            v-model="currentPage"
            :total-rows="rows"
            :per-page="perPage"
            align="center"
            aria-controls="games-table">
        </b-pagination>
    </div>
</template>

<script>

    export default {

        methods: {
            onRowSelected(items) {
                this.selected = items
            },
            sync() {
                fetch('http://localhost:8081/', {
                    method: 'get'
                })
            },
            reloadGames() {
                fetch('http://localhost:8081/games', {
                    method: 'get'
                }).then(response => {
                    return response.json()
                }).then(jsonData => {
                    this.games = jsonData
                })
                fetch('http://localhost:8081/arbitrages', {
                    method: 'get'
                }).then(response => {
                    return response.json()
                }).then(jsonData => {
                    this.arbitrages = jsonData
                })
            }
        },

        data() {
            return {
                sortBy: 'bookmaker',
                sortDesc: true,
                selectMode: 'single',
                fields: [
                    { key: 'firstTeam' },
                    { key: 'secondTeam' },
                    { key: 'firstTeamCoefficient' },
                    { key: 'secondTeamCoefficient' },
                    { key: 'bookmaker' }
                ],
                games: [],
                currentPage: 1,
                perPage: 10,
                modalShow: false,
                selected: [],
                arbitrages: []
            }
        },

        computed: {
            rows() {
                return this.games.length
            }
        },

        mounted: function() {
            this.reloadGames();
        }
    }
</script>

<style>
  #progress {
    max-width: 1400px;
    margin-left: 8%;
  }
</style>