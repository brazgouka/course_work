<template>
    <div>
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
            <b-form-group id="input-group-2" label="Amount:" label-for="input-2">
                <b-form-input
                id="input-2"
                type="number"
                v-model="amount"
                required
                placeholder="Enter amount"></b-form-input>
            </b-form-group>

            <b-button class="mb-2 mr-sm-2 mb-sm-0" type="submit" variant="primary">Calculate</b-button>
            <b-button type="reset" variant="danger">Reset</b-button><br/><br/>
            <b-table striped hover :items="bets" v-if="visible" :fields="fields"></b-table>
            <span v-if="visible">You will win {{this.win}}</span>
        </b-form>
    </div>
</template>

<script>
  export default {
    data() {
      return {
        fields: ['Team', 'Bet', 'Bookmaker'],
        amount: '',
        show: true,
        bets: [],
        bet: [],
        visible: false,
        win: 0
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()

        fetch('http://localhost:8081/calculate-bet/' + this.amount, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body:JSON.stringify(this.$attrs.selected)
        }).then(response => {
                return response.json()
        }).then(jsonData => {
                this.bet = jsonData
        })
        this.bets = [{'Team': this.bet.firstTeam, 'Bet': Math.round(this.bet.firstTeamBet*100)/100, 'Bookmaker': this.bet.firstTeamBetBookmaker}, 
                     {'Team': this.bet.secondTeam, 'Bet': Math.round(this.bet.secondTeamBet*100)/100, 'Bookmaker': this.bet.secondTeamBetBookmaker}]
        this.win = Math.round(this.bet.win*100)/100
        this.visible = true
      },
      onReset(evt) {
        evt.preventDefault()
        
        this.amount = ''
        
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    }
  }
</script>

<style>
  #input-group-2 {
    max-width: 300px;
    margin-left: 41%;
  }
</style>