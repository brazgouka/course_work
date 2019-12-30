<template>
    <div>
        <br/><b-button pill @click="sync" variant="primary">Refresh</b-button><br/><br/>
        <b-button variant="outline-secondary" :disabled="this.selected.length === 0" @click="modalShow = !modalShow">Calculate Bet</b-button>
        <b-modal @submit="reloadArbitages" title="Calculate Bet" ok-only v-model="modalShow"><CalculateBet :selected="selected[0]" /></b-modal>
        <br/><br/>
        <b-table id="arbitrages-table" selectable striped hover @row-selected="onRowSelected" :select-mode="selectMode" :sort-desc.sync="sortDesc" :sort-by.sync="sortBy" :current-page="currentPage" :per-page="perPage" :items="arbitrages" :fields="fields">
            <template v-slot:cell(selected)="{ rowSelected }">
        <template v-if="rowSelected">
          <span aria-hidden="true">&check;</span>
          <span class="sr-only">Selected</span>
        </template>
        <template v-else>
          <span aria-hidden="true">&nbsp;</span>
          <span class="sr-only">Not selected</span>
        </template>
      </template>
        </b-table>
        <b-pagination
            v-model="currentPage"
            :total-rows="rows"
            :per-page="perPage"
            align="center"
            aria-controls="arbitrages-table">
        </b-pagination>
    </div>
</template>

<script>
    import CalculateBet from './CalculateBet.vue'
    
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
            reloadArbitages() {
                fetch('http://localhost:8081/arbitrages', {
                    method: 'get'
                }).then(response => {
                    return response.json()
                }).then(jsonData => {
                    this.arbitrages = jsonData
                })
            }
        },
        components: {
            CalculateBet
        },

        data() {
            return {
                sortBy: 'firstTeam',
                sortDesc: true,
                fields: [
                    { key: 'firstTeam' },
                    { key: 'secondTeam' },
                    { key: 'firstTeamCoefficient' },
                    { key: 'secondTeamCoefficient' },
                    { key: 'firstTeamBookmaker' },
                    { key: 'secondTeamBookmaker' },
                    { key: 'arbitrage'}
                ],
                arbitrages: [],
                currentPage: 1,
                perPage: 5,
                selectMode: 'single',
                modalShow: false,
                selected: []
            }
        },

        computed: {
            rows() {
                return this.arbitrages.length
            }
        },

        mounted: function() {
            this.reloadArbitages();
        }
    }
</script>