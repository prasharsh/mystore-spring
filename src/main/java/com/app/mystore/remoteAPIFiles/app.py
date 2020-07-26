#Author : Parth Panchal
#B00845025
#Customized Nurse Scheduling Algorithm
# references web source : https://developers.google.com/optimization/scheduling/employee_scheduling
# deployed endpoint : https://crewschedulingalgo-n7i4rbxkiq-uc.a.run.app
from __future__ import print_function
from ortools.sat.python import cp_model

from flask import Flask, jsonify,request
import os

app = Flask(__name__)

@app.route('/', methods=['POST'])
def generate_schedule():
    req_data = request.get_json(force = True)
    print(req_data)
    num_nurses = int(req_data['num_nurses'])

    num_shifts = int(req_data['num_shifts'])
    num_days = int(req_data['num_days'])
    shift_requests = req_data['shift_requests']
    #num_nurses = int(request.args.get('num_nurses'))
    #num_shifts = int(request.args.get('num_shifts') )
    #num_days = int(request.args.get('num_days'))
    #shift_requests = list(request.args.get('shift_requests'))
    print("all_nurses" + str(num_nurses))
    print("all_shifts" + str(num_shifts))
    print("all_shifts" + str(num_days))
    print(type(shift_requests))
    all_nurses = range(num_nurses)
    all_shifts = range(num_shifts)
    all_days = range(num_days)

    # Creates the model.
    model = cp_model.CpModel()

    # Creates shift variables.
    # shifts[(n, d, s)]: nurse 'n' works shift 's' on day 'd'.
    shifts = {}
    for n in all_nurses:
        for d in all_days:
            for s in all_shifts:
                shifts[(n, d,
                        s)] = model.NewBoolVar('shift_n%id%is%i' % (n, d, s))

    # Each shift is assigned to exactly one nurse in .
    for d in all_days:
        for s in all_shifts:
            model.Add(sum(shifts[(n, d, s)] for n in all_nurses) == 1)

    # Each nurse works at most one shift per day.
    for n in all_nurses:
        for d in all_days:
            model.Add(sum(shifts[(n, d, s)] for s in all_shifts) <= 1)

    # min_shifts_assigned is the largest integer such that every nurse can be
    # assigned at least that number of shifts.
    min_shifts_per_nurse = (num_shifts * num_days) / num_nurses
    max_shifts_per_nurse = min_shifts_per_nurse + 1
    min_shifts_per_nurse = int(min_shifts_per_nurse)
    max_shifts_per_nurse = int( max_shifts_per_nurse)
    for n in all_nurses:
        num_shifts_worked = sum(
            shifts[(n, d, s)] for d in all_days for s in all_shifts)
        print(" M "+str(type(num_shifts_worked)))
        model.Add(min_shifts_per_nurse <= num_shifts_worked)
        model.Add(num_shifts_worked <= max_shifts_per_nurse)

    model.Maximize(
        sum(shift_requests[n][d][s] * shifts[(n, d, s)] for n in all_nurses
            for d in all_days for s in all_shifts))
    # Creates the solver and solve.
    solver = cp_model.CpSolver()
    solver.Solve(model)
    schedule_result = []
    for d in all_days:
        print('Day', d)
        row = []
        for n in all_nurses:
            for s in all_shifts:
                if solver.Value(shifts[(n, d, s)]) == 1:
                    if shift_requests[n][d][s] == 1:
                        row.append([d,n,s])
                        print('Nurse', n, 'works shift', s, '(requested).')
                    else:
                        #row.append([d, n, s])
                        print('Nurse', n, 'works shift', s, '(not requested).')
        schedule_result.append(row)

    # Statistics.
    #print(schedule_result)

    print('Statistics')
    print('  - Number of shift requests met = %i' % solver.ObjectiveValue(),
          '(out of', num_nurses * min_shifts_per_nurse, ')')
    print('  - wall time       : %f s' % solver.WallTime())
    return jsonify(schedule_result)

if __name__ == '__main__':
    app.run(debug=True,host='0.0.0.0',port=int(os.environ.get('PORT', 8080)))
